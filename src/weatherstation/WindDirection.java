package weatherstation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1960681
 */
public enum WindDirection {

        N(0),
        NNE(1),
        NE(2),
        ENE(3),
        E(4),
        ESE(5),
        SE(6),
        SSE(7),
        S(8),
        SSW(9),
        SW(10),
        WSW(11),
        W(12),
        WNW(13),
        NW(14),
        NNW(15);
        
        public int value;
        
        WindDirection(int value) {
            this.value = value;
        }
}
