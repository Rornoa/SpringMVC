package com.example.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Класс, описывающий комнаты отеля.
 *
 * @category - категория номера (Люкс , бизес, эконом класс).
 * @florNumber - Этаж, на котором расположена комната.
 * @viewFrom - Какой вид открывается из окна номера.
 * @roomNumber - Номер комнаты номера.
 * @bedAmount - Колличество мест в номере.
 * @pricePerNight - цента комнаты за одну ночь.
 * @status - состояние номера (Занят, не убран, свободен).
 *
 * @Author joniker.e@mail.ru
 * @version 0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) long id; // still set automatically
    private Category category;
    private int floorNumber;
    private View windowView;
    private int price;
    private int roomNumber;
    private int bedAmount;
    private int pricePerNight;
    private Status status;

    public Room(int roomNumber) {
    }

    public enum Category{
        LUX,
        ECO,
        BIS
    }

    public enum Status{
        NOT_AVAILABLE,
        NOT_CLEANED,
        AVAILABLE

    }

    public enum View{
        FOREST,
        SEA,
        ROAD
    }
}
