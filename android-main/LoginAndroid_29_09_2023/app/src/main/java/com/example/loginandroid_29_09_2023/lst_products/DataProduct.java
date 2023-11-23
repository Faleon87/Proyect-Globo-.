package com.example.loginandroid_29_09_2023.lst_products;


import com.example.loginandroid_29_09_2023.beans.Productos;

import java.util.ArrayList;

public class DataProduct {
        //Atributos
        private String message;
        private ArrayList<Productos> lstPeliculas;
        // Getters y setters
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public ArrayList<Productos> getLstPeliculas() {
        return lstPeliculas;
        }

        public void setLstPeliculas(ArrayList<Productos> lstPeliculas) {
        this.lstPeliculas = lstPeliculas;
        }


    }


