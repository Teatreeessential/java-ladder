package step2.domain;

import step2.util.LadderGameUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line implements Iterable<Boolean>{
    private List<Boolean> pointList;

    public Line(List<Boolean> pointList) {
        this.pointList = pointList;
    }

    public static Line create(int countOfPerson) {

        List<Boolean> pointList = new ArrayList<>();

        return IntStream.range(0, countOfPerson)
                .mapToObj(idx -> pointList.add(checkPointRule(idx, pointList)))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Line::new));
    }

    private static void validLineCreate(int countOfPerson) {
        if (countOfPerson < 1) {
            throw new IllegalArgumentException("라인 생성시 적어도 한명 이상의 사다리게임 참가자가 필요합니다.");
        }
    }

    public int move(int startingPoint) {
        int resultPoint = startingPoint;

        if (pointList.get(startingPoint - 1)) {
            resultPoint -= 1;
        }

        if (pointList.get(startingPoint + 1)) {
            resultPoint += 1;
        }

        return resultPoint;
    }

    private static boolean checkPointRule(int currentInx, List<Boolean> pointList) {
        if (currentInx > 1) {
            return pointList.get(currentInx - 2) && pointList.get(currentInx - 1) ? false : LadderGameUtil.getRandomBoolean();
        }

        return LadderGameUtil.getRandomBoolean();
    }

    @Override
    public Iterator<Boolean> iterator() {
        return pointList.iterator();
    }
}
