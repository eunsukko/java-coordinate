package coordinate.controller;

import coordinate.domain.Point;
import coordinate.view.InputView;

import java.util.List;

public class CoordinateController {
    public static List<Point> getCoordinates() {
        InputView inputView = new InputView();
        return inputView.inputCoordinates();
    }
}
