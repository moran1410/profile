#include <stdio.h>
#include <stdlib.h>
#include <math.h>


// function that returns factorial of a factorial function
int superFactorial1(int value){

    // stop condition for recursion
    if (value == 0) return 1;
    if (value == 1) return 1;

    //recursive calling that calculates factorial of value times factorial of the same value minus 1 until it reaches 1
    return factorial(value)*superFactorial1(value-1);
}

// function that returns the factorial amount of a given value
int factorial(int value){

// stop condition for recursion
if (value == 0) return 1;
if (value == 1) return 1;

//recursion to that where value will multiplied with itself minus 1 until it reaches 1
return value*factorial(value - 1);


}

int superFactorial2(int value, int value2){
//end result for recursion to stop
if (value == 0) return 1;
if (value == 1) return 1;

// applying power and factorial function with recursion. function 'pow' power value increases with each recursion while value decreases
return pow(value,(value2-(value-1)))*superFactorial2(value - 1,value2);

}

// function used to assign factorial function #1 or #2
int assignFactorialFunction(int value, int funcType1){

// check which option function to call based on input

    if(funcType1 == 1){

    //print out so user knows which function was chosen
   // printf("superFactorial1 function was activated\n\n");

    //call chosen function
    superFactorial1(value);

    }

    else if(funcType1 == 2){
    //print out so user knows which function was chosen
    //printf("superFactorial2 function was activated\n\n");

    //call chosen function
    superFactorial2(value,value);

    }


}

int main()
{

    int value, funcType, printout;
    //receive value and function choice from user
   // printf("Enter value for super factorial function and then choose function 1 or 2:\n");
    scanf("%d%d",&value, &funcType);

    //call recursive functions based on given value and function choice
    printout = assignFactorialFunction(value, funcType);

    printf("%d \n", printout);

    return 0;
}
