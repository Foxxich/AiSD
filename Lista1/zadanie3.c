#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <windows.h>

typedef struct LIST{
    struct LIST *next;
    struct LIST *previous;
    int key;
}LIST;

void add (LIST **head, int key){
    LIST *tmp;
    LIST *new = NULL;

    new = (LIST *)malloc(sizeof(struct LIST));
    new->key = key;
    new->previous = NULL;

    if(*head == NULL){
        new->previous = new;
        new->next = new;
        *head = new;
    } else{
        tmp = *head;
        while(tmp->next != *head){
            tmp = tmp->next;
        }
        tmp->next=new;
        new->previous=tmp;
        new->next=*head;
        tmp=*head;
        tmp->previous=new;
    }
}

int size (LIST **head){
    int i=0;
    LIST *tmp = *head;
    do{
        tmp = tmp->next;
        i++;
    }
    while(tmp != *head);
    return i;
}

void merge(LIST **first, LIST **second){
    LIST *tmp = *first;
    LIST *tmp2 = *second;
    if(tmp == NULL || tmp2 == NULL){
        printf("At least one of the lists is empty\n");
        return;
    }
    while(tmp->next != *first){
        tmp = tmp->next;
    }
        tmp->next = *second;
        tmp2->previous = tmp;
    while(tmp2->next != *second){
        tmp2 = tmp2->next;
    }
    tmp2->next = *first;
    tmp = *first;
    tmp->previous = tmp2;
    *second = NULL;
    free(*second);

}

void show(LIST **head){
    LIST *tmp = *head;
    if(tmp == NULL){
        printf("List is empty\n");
    }
    else {
        do{
            printf("%d " , tmp->key);
            tmp = tmp->next;
        }
        while(tmp != *head);
        printf("\n");
    }
}

void showlast(LIST **head){
    LIST *tmp = *head;
    if(tmp == NULL){
        printf("List is empty\n");
    }
    else {
        printf("%d \n" , tmp->previous->key);
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

LIST *get (LIST **head,int x, int size){
    LIST *tmp = *head;
    int i;
    if(x<=size/2){
        for (i = 1; i <= x; ++i) {
            if(tmp != NULL){
                tmp=tmp->next;
            } else{
                printf("Element doesnt exist\n");
                return NULL;
            }
        }
    } else{
        for (i = 1; i <= size - x+1; ++i) {
            if(tmp != NULL){
                tmp=tmp->previous;
            } else{
                printf("Element doesnt exist \n");
                return NULL;
            }
        }
    }
    return tmp;
}

void avgtime (LIST *head, int n){
    SYSTEMTIME timer;
    int start;
    int end;
    int sizeL = size(&head);
    double sum = 0;
    double avg = 0;

    for (int i=1;i<=10000;i++){
        GetSystemTime(&timer);
        start = (timer.wSecond * 1000) + timer.wMilliseconds;
        LIST *x = get(&head,n,sizeL);
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

    for (int i=1;i<=1000;i++){
        add(&test, rand());
    }
    show(&test);
    avgtime(test,1);
    avgtime(test,250);
    avgtime(test,500);
    avgtime(test,750);
    avgtime(test,1000);
    avgtime(test,(rand()%1000)+1);

    add(&head,4);
    add(&head,5);
    add(&sec,8);
    add(&sec,7);
    show(&head);
    printf("Size of head %d\n",size(&head));
    showlast(&head);
    merge(&head,&sec);
    printf("sec is : ");
    show(&sec);
    printf("head is : ");
    show(&head);
    printf("Number of elements in head %d\n",size(&head));
    printf("The last element in list is ");
    showlast(&head);
    printf("The first element in list is ");
    showfirst(&head);
}