package com.nga.vaadinstudy;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.awt.*;

@Route
public class MainView extends VerticalLayout {

    public MainView() {
        Button button = new Button("Click me", event -> Notification.show("Clicked!"));
        add(button);
    }
}
