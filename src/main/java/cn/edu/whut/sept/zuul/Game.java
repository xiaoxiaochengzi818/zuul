/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 *
 * 如果想开始执行这个游戏，用户需要创建Game类的一个实例并调用“play”方法。
 *
 * Game类的实例将创建并初始化所有其他类:它创建所有房间，并将它们连接成迷宫；它创建解析器
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏。
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 1.0
 */
package cn.edu.whut.sept.zuul;

import java.util.Stack;

public class Game {
    /**
     *记录解析器.
     */
    private Parser parser;
    /**
     * 记录当前房间.
     */
    private Room currentRoom;
    /**
     * 记录初始房间.
     */
    private Room firstRoom;
    /**
     * 记录第二个房间.
     */
    private Room secondRoom;
    /**
     * 记录第三个房间.
     */
    private Room thirdRoom;
    /**
     * 记录第四个房间.
     */
    private Room fourthRoom;
    /**
     * 记录第五个房间.
     */
    private Room fifthRoom;
    /**
     * 创建一个房间栈.
     */
    private Stack<String> rooms = new Stack<String>();

    /**
     *获得栈顶指针.
     * @return 返回栈顶指针
     */
    public Stack<String> getRooms() {
        return rooms;
    }

    /**
     * 储存数据栈.
     * @param room0 房间数据栈
     */
    public void setRooms(final Stack<String> room0) {
        this.rooms = room0;
    }

    /**
     * Game类的构造函数，用于创建房间和解析器对象.
     */
    public Game() {
        createRooms();
        parser = new Parser();
    }

    /**
     * 创建房间及对应描述，以及可去的方向和对应房间.
     */
    private void createRooms() {
        //Room outside, theater, pub, lab, office;

        // create the rooms
        Room outside = new Room("outside the main entrance of the university");
        Room theater = new Room("in a lecture theater");
        Room pub = new Room("in the campus pub");
        Room lab = new Room("in a computing lab");
        Room office = new Room("in the computing admin office");

        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside;  // start game outside
        firstRoom = outside;
        secondRoom = theater;
        thirdRoom = pub;
        fourthRoom = lab;
        fifthRoom = office;
    }

    /**
     * 游戏运行开始的地方.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            if (command == null) {
                System.out.println("I don't understand...");
            } else {
                finished = command.execute(this);
            }
        }

        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, ");
        System.out.println("incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * 储存当前房间.
     * @return 返回当前房间
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * 记录当前房间.
     * @param room Room类对象
     */
    public void setCurrentRoom(final Room room) {
        this.currentRoom = room;
    }

    /**
     * 储存第一个房间.
     * @return 返回第一个房间
     */
    public Room getFirstRoom() {
        return firstRoom;
    }

    /**
     * 储存第二个房间.
     * @return 返回第二个房间
     */
    public Room getSecondRoom() {
        return secondRoom;
    }

    /**
     * 储存第三个房间.
     * @return 返回第三个房间
     */
    public Room getThirdRoom() {
        return thirdRoom;
    }

    /**
     * 储存第四个房间.
     * @return 返回第四个房间
     */
    public Room getFourthRoom() {
        return fourthRoom;
    }

    /**
     * 储存第五个房间.
     * @return 返回第五个房间
     */
    public Room getFifthRoom() {
        return fifthRoom;
    }
}
