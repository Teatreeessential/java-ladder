package step2.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputParticipantsName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String participantsNames = scanner.next();

        return participantsNames;
    }

    public static String inputPrizes() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String inputPrizes = scanner.next();

        return inputPrizes;
    }

    public static int inputLadderDepth() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderDeptth = scanner.nextInt();

        return ladderDeptth;
    }

    public static String inputResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        String inputResult = scanner.next();

        return inputResult;
    }
}
