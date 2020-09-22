package step2.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {

    public static Prize startBySpecificUser(String name, UserList userList, Ladder ladder, PrizeList prizeList) {
            return prizeList.getWinningPrize(ladder.move(userList.getUserstartingPoint(name)));
    }

    public static Map<User, Prize> startByAllUser(UserList userList, Ladder ladder, PrizeList prizeList) {
            return userList.stream()
                    .collect(Collectors.toMap(user -> user, user -> prizeList.getWinningPrize(ladder.move(userList.getUserstartingPoint(user)))));
    }



}
