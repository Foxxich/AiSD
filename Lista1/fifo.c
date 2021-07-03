#include <stdlib.h>
#include <stdio.h>

typedef struct FIFO{
    struct FIFO *next;
    int key;
}FIFO;

void push (FIFO **head, FIFO **tail, int key){
    FIFO *new;
    FIFO *tmp;
    new = (FIFO *)malloc(sizeof(struct FIFO));
    new->key = key;
    new->next = NULL;
    printf("Pushed: %d \n" ,key);
    if(*head == NULL){
        *head=new;
        *tail=new;
    }
    else {
        tmp = *tail;
        tmp->next=new;
        *tail=new;
    }
}

void pop(FIFO **head,FIFO **tail){
    FIFO *tmp = *head;
    if(*head == NULL){
        printf("Queue is empty\n");
    }
    else{
        printf("Delete: %d \n" , tmp->key);
        if(*head==*tail){
            *tail=NULL;
        }
        *head=tmp->next;
        free(tmp);
    }
}
void show(FIFO *head){
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
    FIFO *head = NULL;
    FIFO *tail = NULL;

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