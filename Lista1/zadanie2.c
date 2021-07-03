#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <windows.h>

typedef struct LIST{
    struct LIST *next;
    int key;
}LIST;

void add (LIST **head, int key){
    LIST *new;
    LIST *tmp;
    new = (LIST *)malloc(sizeof(struct LIST));
    new->key = key;
    new->next = NULL;

    if(*head == NULL){
        *head = new;
    }
    else {
        tmp = *head;
        while(tmp->next != NULL){
            tmp = tmp->next;
        }
        tmp->next = new;
    }
}

void merge(LIST **first, LIST **second){
    LIST *tmp = *first;
    while(tmp->next != NULL){
        tmp = tmp->next;
    }
    tmp->next = *second;
    *second = NULL;
    free(*second);
}

LIST *get (LIST **head,int x){
    LIST *tmp = *head;
    for (int i = 1; i <= x; ++i) {
        if(tmp != NULL){
            tmp=tmp->next;
        } else{
            printf("Element doesnt exist\n");
            return NULL;
        }
    }
    return tmp;
}

void show(LIST *head){
    if(head == NULL){
        printf("List is empty\n");
    }
    else {
        while(head != NULL){
            printf("%d " , head->key);
            head = head->next;
        }
        printf("\n");
    }
}

void showfirst(LIST **head){
    LIST *tmp = *head;
    if(tmp == NULL){
        printf("List is empty\n");
    }
    else {
        printf("%d \n" , tmp->key);
    }
}

void avgtime (LIST *head, int n){
    SYSTEMTIME timer;
    int start;
    int end;
    double sum = 0;
    double avg = 0;

    for (int i=1;i<=10000;i++){
        GetSystemTime(&timer);
        start = (timer.wSecond * 1000) + timer.wMilliseconds;
        LIST *x = get(&head,n);
        GetSystemTime(&timer);
        end = (timer.wSecond * 1000) + timer.wMilliseconds;
        sum = sum + (end - start);
    }
    avg = sum/10000.0;
    printf("Avg time for n = %d : %f (in miliseconds)\n",n,avg);
}


int main() {
    LIST *test = NULL;
    LIST *head = NULL;
    LIST *sec = NULL;
    srand(time(NULL));

    for (int i = 1; i <= 1000; i++) {
        add(&test, rand());
    }
    avgtime(test, 1);
    avgtime(test,250);
    avgtime(test,500);
    avgtime(test,750);
    avgtime(test,1000);
    avgtime(test,(rand()%1000)+1);

    add(&head, 4);
    add(&head, 5);
    add(&sec, 6);
    add(&sec, 7);
    merge(&head, &sec);
    printf("sec is : ");
    show(sec);
    printf("head is : ");
    show(head);
    printf("The first element in list is ");
    showfirst(&test); 
}