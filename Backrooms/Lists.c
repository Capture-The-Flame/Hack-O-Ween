#include <stdio.h>
#include <stdlib.h>
#include "Lists.h"

ListNode* CreateMaze(){
    ListNode *ptr = (ListNode*)malloc(4 * sizeof(ListNode));

    if(ptr!=NULL){
        return ptr;
    }
    else
        return ptr;
}

void DestroyMaze(ListNode *node){
    free(node);
}