package step2.domain;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Ladder implements Iterable<Line> {

    private List<Line> lineList;

    private Ladder(List<Line> lineList) {
        this.lineList = lineList;
    }

    public static Ladder create(int depth, int countOfPerson) {
        validLadderCreate(depth, countOfPerson);

        return IntStream.range(0, depth)
                .mapToObj(line -> Line.create(countOfPerson))
                .collect(Collectors.collectingAndThen(toList(), Ladder::new));
    }

    private static void validLadderCreate(int depth, int countOfPerson) {
        if (depth < 1) {
            throw new IllegalArgumentException("사다리의 깊이는 최소 1이상이여야 합니다.");
        }

        if (countOfPerson < 1) {
            throw new IllegalArgumentException("최소 한명 이상의 게임 참여자가 필요 합니다.");
        }
    }

    public int move(int startingPoint) {
        int resultPoint = startingPoint;

        for (Line line : lineList) {
            resultPoint = line.move(resultPoint);
        }

        return resultPoint;
    }

    @Override
    public Iterator<Line> iterator() {
        return lineList.iterator();
    }
}
