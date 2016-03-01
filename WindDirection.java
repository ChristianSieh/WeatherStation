/******************************************************************************
 * File: WindDirection.java                                                   *
 ******************************************************************************/

package weatherstation;

/*==============================================================================
    Enumerator: WindDirection

    Description: 
        This file defines an enum type for wind direction from 0 - 15 going
    counter-clockwise from North (N).
==============================================================================*/
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
        
        /*======================================================================
            Function: WindDirection()
    
            Description: 
                This function is a constructor for the WindDirection enum, it
            sets the value for the wind direction based on its parameter. 
    
            Parameters: int value - Wind direction value (N, NNE, NE, ENE, E..)
    
            Returns: None
        ======================================================================*/
        WindDirection(int value) {
            this.value = value;
        }
}
