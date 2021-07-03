public class Task {
    String name;
    double priority;

    /** Constructor **/
    public Task(String name, int priority)
    {
        this.name = name;
        this.priority = priority;
    }
    public Task(String name, double priority)
    {
        this.name = name;
        this.priority = priority;
    }
    /** toString() **/
    public String toString()
    {
        return "Job Name : "+ name +" ("+ priority+")";
    }
}

//number of zero in number
