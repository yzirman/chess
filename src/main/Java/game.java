public class game {
    
    piece[][] board = instantiateGame();

    public int score(piece[][] board) {
        int whiteScore = 0;
        int blackScore = 0;
       for (piece[] line : board) {
           for (piece piece : line) {
               if (piece != null) {
                   if (piece.getColor()) {
                       whiteScore += piece.getWorth();
                   } else {
                       blackScore += piece.getWorth();
                   }
               }
           }
       }
       return whiteScore - blackScore;
    }
    private piece[][] instantiateGame() {
        piece[][] board = new piece[8][8];
        //White
        board[0][0] = new rook(true, 11);
        board[0][1] = new knight(true, 21);
        board[0][2] = new bishop(true, 31);
        board[0][3] = new queen(true, 41);
        board[0][4] = new king(true, 51);
        board[0][5] = new bishop(true, 61);
        board[0][6] = new knight(true, 71);
        board[0][7] = new rook(true, 81);
        board[1][0] = new pawn(true, 12);
        board[1][1] = new pawn(true, 22);
        board[1][2] = new pawn(true, 32);
        board[1][3] = new pawn(true, 42);
        board[1][4] = new pawn(true, 52);
        board[1][5] = new pawn(true, 62);
        board[1][6] = new pawn(true, 72);
        board[1][7] = new pawn(true, 82);
        //Black
        board[7][0] = new rook(false, 18);
        board[7][1] = new knight(false, 28);
        board[7][2] = new bishop(false, 38);
        board[7][3] = new queen(false, 48);
        board[7][4] = new king(false, 58);
        board[7][5] = new bishop(false, 68);
        board[7][6] = new knight(false, 78);
        board[7][7] = new rook(false, 88);
        board[6][0] = new pawn(false, 17);
        board[6][1] = new pawn(false, 27);
        board[6][2] = new pawn(false, 37);
        board[6][3] = new pawn(false, 47);
        board[6][4] = new pawn(false, 57);
        board[6][5] = new pawn(false, 67);
        board[6][6] = new pawn(false, 77);
        board[6][7] = new pawn(false, 87);
        return board;
    }
    private boolean canMove(piece[][] board, piece piece, int toPosition) {
        //account if piece in future spot
        //
        int currentXY = piece.getPosition();
        if (toPosition == currentXY) {
            return false;
        }
        int currentX = currentXY / 10;
        int currentY = currentXY % 10;
        int futureX = toPosition /10;
        int futureY = toPosition % 10;
        int temp = 0;
        int changeX = currentX < futureX ? 1 : -1;
        int changeY = currentY < futureY ? 1 : -1;
        //move doesn't go out of bounds
        if (futureY > 8 || futureY < 1 || futureX > 8 || futureX < 1 || currentX > 8 || currentX < 1 || currentY > 8 || currentY < 1) {
            return false;
        }
        if (piece instanceof rook || piece instanceof king || piece instanceof pawn) {
            while (currentX != futureX) {
                currentX += changeX;
                if (board[currentX-1][currentX-1] != null) {
                    return false;
                }
            }
            while (currentY != futureY) {
                currentY+= changeY;
                if (board[currentY-1][currentY-1] != null) {
                    return false;
                }
            }
            //deal with final position;
        }
    }
}