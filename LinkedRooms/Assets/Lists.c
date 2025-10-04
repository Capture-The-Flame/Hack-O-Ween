#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Lists.h"

ListNode* CreateMaze(){

    ListNode* start = (ListNode*)malloc(sizeof(ListNode));
    ListNode* second = (ListNode*)malloc(sizeof(ListNode));
    ListNode* third = (ListNode*)malloc(sizeof(ListNode));
    ListNode* fourth = (ListNode*)malloc(sizeof(ListNode));
    ListNode* final = (ListNode*)malloc(sizeof(ListNode));

    snprintf(start->value, sizeof start->value, "%s", "Start");
    start->up=second;
    start->left= second->down = start;
    start->right=third;

    snprintf(second->value, sizeof second->value, "%s", "BOO");
    second->up = second->right = second;
    second->left= second->down = start;

    strcpy(third->value,"AAAAHH");
    third->up =fourth;
    third->left=start;
    third->down = third->right = third;

    strcpy(fourth->value,"TRICK-OR-TREAT");
    fourth->left=second;
    fourth->up=fourth->down = fourth;
    fourth->right=final;

    strcpy(final->value,"flag{skin_steaker}");
    final->down=final->left=final->up=final->right=final;

    return start;
}

void DestroyMaze(ListNode *start){   
    free(start->right->up->right);
    free(start->right->up->left);
    free(start->right->up);
    free(start->right);
    free(start);
}
