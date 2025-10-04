#include <stdio.h>
#include <stdlib.h>

#include "Lists.h"

int main(){
    //node is now the start of the maze that you can enter and evaluate
    ListNode* node = CreateMaze();

    printf("%s", "Maze Created!");
    return 0;
}