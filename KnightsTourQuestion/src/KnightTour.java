
/**
 * 
 * Knight's Tour means you have a knight on an empty chessboard of NxN size.
 * How can you move the knight on the chessboard such that the knight visits
 * each spot on the chessboard once (and only once), and it traverses the entire board.
 * 
 * I also go to the HashMap (hashtable) - I take a Data Structure approach
 * 
 */

public class KnightTour
{
  public KnightTour (int sizeOfChessBoard, int startX, int startY) 
  {
    // initialize an NxN chessboard where "sizeOfChessboard" = "N"
    int[][] chessboard = new int[sizeOfChessBoard][sizeOfChessBoard];
    
    // initialize chessboard with -1 values in all squares.
    //   -1 represents "not visited", therefore != -1 means visited
    for (int i = 0; i<sizeOfChessBoard; i++)
      for (int j = 0; j<sizeOfChessBoard; j++)
        chessboard[i][j] = -1;
    
    // recursive algorithms should have:
    //  1. a starting point
    //  2. an increment towards the end point (through calling itself)
    //  3. an end point
    
    tryToMove(startX, startY, 0 , 0, 0, chessboard, sizeOfChessBoard);
    
  }
  
  public boolean tryToMove (int currentX, int currentY, int moveCount, int xDirection, int yDirection, int[][] chessboard, int sizeOfChessBoard)
  {
    int newX = currentX + xDirection;
    int newY = currentY + yDirection;
    
    // 1. check and make sure that the move is within the bounds of the chessboard
    if (newX < 0 || newX > chessboard.length - 1)
      return false;
    
    if (newY < 0 || newY > chessboard.length - 1)
      return false;
        
    // 2. check and make sure that we haven't already visited the spot we're moving to
    if (chessboard[newX][newY] != -1)
      return false;
    
    // now we need to try and visit this spot!
    chessboard[newX][newY] = moveCount; // set this spot as "visited"
    moveCount++;
    
    // print out the current position
//    System.out.println("Move " + moveCount + " is to (" + newX + ", " 
//                       + newY +")");
    
    // knight can move:
    /**
     * RIGHT, UP
     * UP, RIGHT
     * UP, LEFT
     * LEFT, UP
     * LEFT, DOWN
     * DOWN, LEFT
     * DOWN, RIGHT
     * RIGHT, DOWN
     */
    
    tryToMove(newX, newY, moveCount, 2, 1, chessboard, sizeOfChessBoard);
    tryToMove(newX, newY, moveCount, 1, 2, chessboard, sizeOfChessBoard);
    tryToMove(newX, newY, moveCount, -1, 2, chessboard, sizeOfChessBoard);
    tryToMove(newX, newY, moveCount, -2, 1, chessboard, sizeOfChessBoard);
    tryToMove(newX, newY, moveCount, -2, -1, chessboard, sizeOfChessBoard);
    tryToMove(newX, newY, moveCount, -1, -2, chessboard, sizeOfChessBoard);
    tryToMove(newX, newY, moveCount, 1, -2, chessboard, sizeOfChessBoard);
    tryToMove(newX, newY, moveCount, 2, -1, chessboard, sizeOfChessBoard);
    
    if (moveCount == sizeOfChessBoard * sizeOfChessBoard) {
      for (int i = 0; i<sizeOfChessBoard; i++)
      {
        for (int j = 0; j<sizeOfChessBoard; j++)
        {
          System.out.print(chessboard[i][j] + ", ");
        }
        System.out.println();
      }
      System.exit(0); // if we don't exit here, it will continue to try and find
                      //  additional solutions (which could take a VERY long time)
      return true;
    }
    else
    {
      chessboard[newX][newY] = -1;
      return false;
    }
      
  }
}
