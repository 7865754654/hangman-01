public class Hangman {

    public static void drawHangman(int gameAttempt) {
        String picturePartHangman = Hangman.PART_HANGMAN[gameAttempt];
        System.out.println(picturePartHangman);
    }

    public static final String[] PART_HANGMAN = {
            """
                          
                          _______
                         |       |
                         |       0
                         |      /|\\
                         |      / \\
                         |      
                         |      
                        =========
                        """,
            """
                          
                          _______
                         |       |
                         |       0
                         |      /|\\
                         |        
                         |      
                         |      
                        =========
                        """,
            """
                          
                          _______
                         |       |
                         |       0
                         |      /|
                         |      
                         |      
                         |      
                        =========
                        """,
            """
                          
                          _______
                         |       |
                         |       0
                         |       |
                         |      
                         |      
                         |      
                        =========
                        """,
            """
                          
                          _______
                         |       |
                         |       
                         |       
                         |      
                         |      
                         |      
                        =========
                        """
    };
}

