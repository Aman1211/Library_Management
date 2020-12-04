package library.controller.action;
import java.util.Timer;

public class SchMain {
	public static void main(String args[])
	{
	Timer time1 = new Timer(); // Instantiate Timer Object
    TaskSch st = new TaskSch(); // Instantiate SheduledTask class
    time1.schedule(st, 0,1000);
	}
}
