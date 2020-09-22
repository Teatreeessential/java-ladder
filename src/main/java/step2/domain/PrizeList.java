package step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class PrizeList {

    private final List<Prize> list;

    private PrizeList(List<Prize> list) {
        this.list = list;
    }

    public static PrizeList create(String prizeList) {
        return Arrays.asList(prizeList.split(","))
                     .stream()
                     .map(Prize::of)
                     .collect(Collectors.collectingAndThen(toList(), PrizeList::new));
    }

    public Prize getWinningPrize(int userPosition) {
        return list.get(userPosition);
    }
}

