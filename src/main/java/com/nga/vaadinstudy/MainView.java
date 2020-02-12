package com.nga.vaadinstudy;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    public MainView() {
        Button button = new Button("Click me", event -> Notification.show("Clicked!"));
        add(button);

        TextField textField = new TextField();

        // Simple inline text
        Span greeting = new Span("Hello stranger");

        textField.addValueChangeListener(event -> greeting.setText("Hello " + event.getValue()));

        add(textField);
        add(greeting);
    }
}
