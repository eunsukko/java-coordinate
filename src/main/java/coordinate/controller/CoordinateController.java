package coordinate.controller;

import coordinate.domain.Point;
import coordinate.domain.PointList;
import coordinate.view.InputView;

import java.util.List;

public class CoordinateController {
    public static PointList getCoordinates() {
        InputView inputView = new InputView();
        return inputView.inputCoordinates();
    }
}
