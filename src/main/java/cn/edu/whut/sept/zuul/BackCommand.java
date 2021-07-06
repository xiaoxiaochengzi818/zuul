package cn.edu.whut.sept.zuul;

public class BackCommand extends Command {
    /**
     * 获得game类的判段值.
     * @param game Game类的对象
     * @return 返回game的判断值
     */
    public boolean execute(final Game game) {
        if (hasSecondWord()) {
            System.out.println("Back where?");
            return false;
        } else if (game.getRooms().empty()) {
            System.out.println("You are already in the original room.");
            return false;
        } else {
            System.out.print("You go back to the last room:");
            String lastRoom0 = game.getRooms().pop();
            System.out.println(lastRoom0);
            Room lastRoom = null;
            switch (lastRoom0) {
                case "outside":
                    lastRoom = game.getFirstRoom();
                    break;
                case "theater":
                    lastRoom = game.getSecondRoom();
                    break;
                case "pub":
                    lastRoom = game.getThirdRoom();
                    break;
                case "lab":
                    lastRoom = game.getFourthRoom();
                    break;
                case "office":
                    lastRoom = game.getFifthRoom();
                    break;
                default:
                    break;
            }
            game.setCurrentRoom(lastRoom);
            System.out.println(lastRoom.getLongDescription());
            return false;
        }
    }
}
