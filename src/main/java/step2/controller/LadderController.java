package step2.controller;

import step2.domain.Ladder;
import step2.domain.LadderGame;
import step2.domain.PrizeList;
import step2.domain.UserList;
import step2.view.InputView;
import step2.view.RenderView;

public class LadderController {

    public static void execute() {
        String participantsNames = InputView.inputParticipantsName();
        UserList userList = UserList.create(participantsNames);

        String inputPrizes = InputView.inputPrizes();
        PrizeList prizeList = PrizeList.create(inputPrizes);

        int inputLadderDepth = InputView.inputLadderDepth();
        Ladder ladder = Ladder.create(inputLadderDepth, userList.getTotalParticipantsCount());

        System.out.println("사다리 결과");

        RenderView.renderUserNameList(userList);
        RenderView.renderLadder(ladder);

        while(true) {
            String inputReulst = InputView.inputResult();

            if (inputReulst.equals("all")) {
                RenderView.renderLadderGameResult(LadderGame.startByAllUser(userList, ladder, prizeList));
            }

            RenderView.renderLadderGameResult(LadderGame.startBySpecificUser(inputReulst, userList, ladder, prizeList));
        }
    }
}


