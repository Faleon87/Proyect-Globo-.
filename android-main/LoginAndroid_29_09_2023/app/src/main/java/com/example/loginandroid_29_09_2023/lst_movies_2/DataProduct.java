package com.example.loginandroid_29_09_2023.lst_movies_2;

import com.example.loginandroid_29_09_2023.beans.Producto;

import java.util.ArrayList;

public class DataProduct {
        //Atributos
        private String message;
        private ArrayList<Producto> lstPeliculas;
        // Getters y setters
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public ArrayList<Producto> getLstPeliculas() {
        return lstPeliculas;
        }

        public void setLstPeliculas(ArrayList<Producto> lstPeliculas) {
        this.lstPeliculas = lstPeliculas;
        }


    }


