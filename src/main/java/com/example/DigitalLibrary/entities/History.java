package com.example.DigitalLibrary.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "history")

public class History {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String bookTitle;
    private LocalDate borrowedDate;
    private LocalDate returnedDate;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getBookTitle() { return bookTitle; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
    public LocalDate getBorrowedDate() { return borrowedDate; }
    public void setBorrowedDate(LocalDate borrowedDate) { this.borrowedDate = borrowedDate; }
    public LocalDate getReturnedDate() { return returnedDate; }
    public void setReturnedDate(LocalDate returnedDate) { this.returnedDate = returnedDate; }
}
