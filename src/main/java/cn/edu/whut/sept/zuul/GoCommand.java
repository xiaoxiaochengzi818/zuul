package cn.edu.whut.sept.zuul;

public class GoCommand extends Command {
    /**
     * 获得game的判断值.
     * @param game Game类的对象
     * @return 返回game的判断值
     */
    public boolean execute(final Game game) {

        if (!hasSecondWord()) {
            System.out.println("Go where?");
        }
        String direction = getSecondWord();

        Room currentRoom = game.getCurrentRoom();

        Room nextRoom = game.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            String s0 = "outside";
            String s1 = "theater";
            String s2 = "pub";
            String s3 = "lab";
            String s4 = "office";
            if (currentRoom == game.getFirstRoom()) {
                game.getRooms().push(s0);
            } else if (currentRoom == game.getSecondRoom()) {
                game.getRooms().push(s1);
            } else if (currentRoom == game.getThirdRoom()) {
                game.getRooms().push(s2);
            } else if (currentRoom == game.getFourthRoom()) {
                game.getRooms().push(s3);
            } else if (currentRoom == game.getFifthRoom()) {
                game.getRooms().push(s4);
            }
            game.setCurrentRoom(nextRoom);
            System.out.println(nextRoom.getLongDescription());
        }
        return false;
    }
}
