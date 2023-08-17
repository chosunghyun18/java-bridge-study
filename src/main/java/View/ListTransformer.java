package View;

import java.util.List;
import java.util.stream.Collectors;

public class ListTransformer {
    public List<List<String>> transform(List<List<String>> originalList) {
        List<List<String>> transformedList = originalList.get(0).stream()
                .map(str -> originalList.stream()
                        .map(innerList -> innerList.get(originalList.get(0).indexOf(str)))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
        return transformedList;
    }
}
