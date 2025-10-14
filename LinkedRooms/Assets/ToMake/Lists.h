
#ifndef LIST_H
#define LIST_H

typedef struct ListNode{
    struct ListNode *up;
    struct ListNode *left;
    struct ListNode *down;
    struct ListNode *right;
    char value[50];
} ListNode;

ListNode* CreateMaze();
void DestroyMaze(ListNode*);


#endif