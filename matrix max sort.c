#include <stdio.h>
#include <stdlib.h>

// swap between two values in a given array
void swap(int* x, int* y){

int swp;

swp = *x;

*x = *y;

*y = swp;


}

//function that returns the index of minimum or maximum value in a given row of a matrix
int maxMinIndex(int** mat1, int row, int arrayLen ){

    int maxMinIndx = 0;

// checks if row is divisible by 2 and then assign the maximum value index to maxMinIndx
    if ((row+1)%2==0){


    for(int j = 0; j < arrayLen; j++){

        if(mat1[row][j] > mat1[row][maxMinIndx])

           maxMinIndx = j;

    }


    }
    // if row is not divisible by 2 assign index of minimum value to maxMinIndx
    else {

        for(int j = 0; j < arrayLen; j++){

        if(mat1[row][j] <= mat1[row][maxMinIndx])

           maxMinIndx = j;

    }
    }

// return index of minimum or maximum value
    return maxMinIndx;

}

// max sort function that receives a NxN size matrix
void maxSort(int** mat1, int arrLen){



    int rowLength, indx1;
// loop through rows of the matrix
    for(int i = 0; i < arrLen; i++ ){


// loop through columns of matrix and sort maximum to minimum or minimum to maximum
        for(rowLength = arrLen; rowLength > 1; rowLength--){

        indx1 = maxMinIndex(mat1,i,rowLength);

        swap(&mat1[i][rowLength-1],&mat1[i][indx1]);

        }
    }



}

// free allocated memory
void deallocateMat(int** matrx, int n){

    for(int i = 0; i < n; i++){
        free(matrx[i]);



    }
    free(matrx);

}

// construct NxN size matrix
int** allocateMat(int arrLen){

    // allocate memory for N size array of int pointers
    int** matrix = malloc(sizeof(int)*arrLen);

    // return NULL if allocation had failed
    if(matrix == NULL) return NULL;

    // loop through array and allocate memory for size N array
    for(int i = 0; i < arrLen; i++){

        matrix[i] = malloc(sizeof(int*)*arrLen);

        // return NULL and deallocate if allocation had failed
        if (matrix[i] == NULL){

            deallocateMat(matrix, i);

            return NULL;
        }
    }
    return matrix;

}
// receive values for NxN matrix
void inputMat (int** matrx, int arrLen){

    //printf("provide %d integer values: ", arrLen*arrLen);

   // loop through the matrix and receive input from user
    for(int i = 0; i < arrLen; i++){

        for(int j =0; j < arrLen; j++){

            scanf("%d", &matrx[i][j]);
        }
    }


}

// print NxN matrix
void printMat (int** matrx, int arrLen){

    // loop through the rows
    for(int i = 0; i < arrLen; i++){

        // loop through columns
        for(int j =0; j < arrLen; j++){

            printf("%d ", matrx[i][j]);
        }
    printf("\n");
    }
}

int main()
{
    // declare pointer of pointers
    int** matrixOne;

    // receive size of matrix from user
    int arrayLength;

   // printf("Enter N for NxN matrix: ");

    scanf("%d", &arrayLength);

    // call function to create a matrix
    matrixOne = allocateMat(arrayLength);

    // call function to receive input from user for matrix values
    inputMat(matrixOne, arrayLength);

    printf("\n");
    //call function to print the matrix to show matrix before sorting
    printMat(matrixOne, arrayLength);


    // call function to sort the matrix
    maxSort(matrixOne,arrayLength);

    printf("\n");
    // call function to print the matrix again to show result
    printMat(matrixOne, arrayLength);



    return 0;
}
