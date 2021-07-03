#include <stdlib.h>
#include <stdio.h>

typedef struct LIFO{
    struct LIFO *previous;
    struct LIFO *next;
    int key;
}LIFO;

void push (LIFO **head, LIFO **tail, int key){
    LIFO *new;
    LIFO *tmp;
    new = (LIFO *)malloc(sizeof(struct LIFO));
    new->key = key;
    new->next = NULL;
    new->previous = NULL;
    //printf("Pushed: %d \n" , key);
    if(*head == NULL){
        *head=new;
        *tail=new;
    }
    else {
        tmp = *tail;
        new->previous = *tail;
        tmp->next=new;
        *tail=new;
    }
}

void pop(LIFO **head,LIFO **tail){
    LIFO *tmp = *tail;
    if(*tail == NULL){
        printf("Queue is empty\n");
    }
    else{
        printf("Delete: %d \n" , tmp->key);
        tmp=tmp->previous;
        if(*tail == *head) {
            *head = NULL;
        } else {
            tmp->next = NULL;
        }
        free(*tail);
        *tail=tmp;
    }
}

void show(LIFO *head){
    if(head == NULL){
        printf("Queue is empty\n");
    }
    else {
        while(head != NULL){
            printf("%d " , head->key);
            head = head->next;
        }
        printf("\n");
    }
}

int main(){
    LIFO *head = NULL;
    LIFO *tail = NULL;

    show(head);
    for (int i = 1; i <= 100; i++) {
        push(&head,&tail,i);
    }
    show(head);
    for (int i = 1; i <= 97; i++) {
        pop(&head,&tail);
    }
    show(head);
}