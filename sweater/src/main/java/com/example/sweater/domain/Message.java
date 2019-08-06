package com.example.sweater.domain;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String text;
    private String tag;

    public String getAutorName(){
        return autor !=null ? autor.getUsername() :"<none>";
    }


    public User getAutor() {
        return autor;
    }

    public void setAutor(User autor) {
        this.autor = autor;
    }
    @ManyToOne(fetch = FetchType.EAGER) //fetch EAGEr говорит о том что мы хотим получать информации об авторе с этим сообщением сразу
    @JoinColumn(name ="user_id")//задаем название колонки в базе по умолчанию было бы autor_id
    private User autor;//связь которая говорит что 1 пользователю могут принадлежать несколько сообщений со стороны сообщения
    public Message(){}
    public Message(String text, String tag,User user
    ) {
        this.autor = user;
        this.text = text;
        this.tag = tag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }





}
