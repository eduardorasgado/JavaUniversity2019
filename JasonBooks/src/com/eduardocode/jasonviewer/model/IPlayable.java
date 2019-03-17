package com.eduardocode.jasonviewer.model;

import java.util.Date;

public interface IPlayable {
    Date startToSee(Date dateI);
    void stoptToSee(Date dateI, Date dateF);
}
