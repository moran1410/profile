#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define UNASSIGNED 0

//initialize global variable to count how many times print function was called
//in order to print 'No solution!' in case 'findSolution' function did not succeed
int printCounter = 0;

// receive a given row and number and iterate through the columns to find if the number exist
// returns true if number exists, false otherwise
bool checkRow( int n, int board[n][n], int row, int someNumber){

    for(int column = 0; column < n; column++){


        if(board[row][column] == someNumber){
          //  printf("check row %3d = %d\n",board[row][column], someNumber );
            return true;
        }
    }


    return false;

}
// receive a given column and number and iterate through the rows to find if the number exist
// returns true if number exists, false otherwise
bool checkColumn( int n, int board[n][n], int column, int someNumber){

    for(int row = 0; row < n; row++){


        if(board[row][column] == someNumber){
          //  printf("check column %3d = %d\n",board[row][column], someNumber );
            return true;
        }
    }


    return false;

}

// to check both row and column validity
bool isValid(int n, int row, int column,int board[n][n], int someNumber){

    // call check row and check column functions, if both true then 'isValid' returns false. meaning the number exist
    return !checkRow(n, board, row, someNumber) && !checkColumn(n, board, column, someNumber);


}

// recursive function to find solution for board. 'n' the size of the board and 'row' and 'column' are used to iterate
// between the cells when the function is recursing
bool findSolution(int n, int board[n][n], int row, int column){



    // stop condition
    if(row == n-1 && column == n){

        printBoard(n, board);
        return true;
    }

    // check if end of row has been reached and then moving to the next row
    if(column == n){

        row++;
        column = 0;
    }

    //check to skip assigned numbers and move to the next column
    if(board[row][column] != UNASSIGNED){

        return findSolution(n, board, row, column + 1);
    }

    // loop between 1 and 'n' to check if numbers are valid to be placed in cell
    for(int someNumber = 1; someNumber <= n; someNumber++){
        // check if valid and then place in cell
        if(isValid(n, row, column, board, someNumber)){

            board[row][column] = someNumber;

            // recursive call to fill in the rest of the board by iterating through columns
            if(findSolution(n, board, row, column+1))
                return true;

        // backtrack if solution haven't been found
        board[row][column] = UNASSIGNED;


        }

    }



    // return false to stop recursing if no assignments are possible

    return false;
}


//function to print board that loops n*n times
void printBoard(int n, int board[n][n]) {



  for (int i = 0; i < n; ++i) {

    for (int j = 0; j < n; ++j) {

      printf("%3d", board[i][j]);

    }

    printf("\n");
  }
    printf("\n");
    printCounter += 1;
}


// function loops n*n times to fill board with user input
void fillBoard(int n, int board[n][n], int rowCheckHistogram[n][n], int colCheckHistogram[n][n]) {

    int sudokuNum;

  for (int row = 0; row < n; ++row) {

    for (int col = 0; col < n; ++col) {

     // printf("Enter a number between 1 and %d in board[%d][%d] or 0 for unassigned: ",n , i+1, j+1);

        scanf("%d", &sudokuNum);

        board[row][col] = sudokuNum;

        //check if actual number was placed and then increase counter in histogram
        if(sudokuNum>0){

        //increase the corresponding number in the column
        colCheckHistogram[sudokuNum - 1][col]+=1;

        // increase the corresponding number in the row e.g. if 3 was entered 3 times in the first row then cell[row][3-1] will increase 3 times
        rowCheckHistogram[row][sudokuNum - 1]+=1;

        }
    }
  }

  printBoard(n, board);
 // printBoard(n, colCheckHistogram);
 // printBoard(n, rowCheckHistogram);
}

// loop throw n*n matrix and initialize all cells to 0
void formatHistogram(int n, int rowCheckHistogram[n][n], int colCheckHistogram[n][n]){

for (int row = 0; row < n; ++row) {

    for (int col = 0; col < n; ++col) {

        rowCheckHistogram[row][col] = 0;
        colCheckHistogram[row][col] = 0;

        }
    }
}

// loop through each cell in the matrix and check if any is bigger than 1. If yes that means one of the input numbers was entered
// more than once and if so then the function returns false
bool checkHistogram(int n, int histogram[n][n]) {

    for (int row = 0; row < n; ++row) {

        for (int col = 0; col < n; ++col) {

            if(histogram[row][col] > 1) return false;

            }

        }
    return true;
}

int main()
{

    int n;
    // receive board dimensions. assumed input is valid as requested
    scanf("%d", &n);

    // assign n*n array and histograms from given input. For the histograms one will be used to count the entries in the rows and the other for columns
    int board[n][n], rowCheckHistogram[n][n], colCheckHistogram[n][n];

    //initialize histograms with zero
    formatHistogram(n, rowCheckHistogram, colCheckHistogram);

    // call for function fill board with user input and update histograms at the same time
    fillBoard(n, board, rowCheckHistogram, colCheckHistogram);



    // call boolean check function to check histograms if both return true then we can proceed to find a solution, otherwise we print no solution
    if(checkHistogram(n, rowCheckHistogram)&&checkHistogram(n, colCheckHistogram)){

    findSolution(n, board, 0, 0);

    //check if findSolution managed to print the board, if not then we print out no solution
    if(printCounter!=2) printf("No solution !");

    }

    else printf("No solution !");







    return 0;
}
