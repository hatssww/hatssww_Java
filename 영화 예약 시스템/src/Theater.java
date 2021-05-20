import java.util.ArrayList;

public class Theater {

    private Seat[][] seats;
    private int rowCount, colCount;

    public Theater(int rowCount, int colCount) {
        // 알파벳은 26개만 존재
        if (rowCount > 26) {
            rowCount = 26;
        }

        // 좌석 배열 생성
        seats = new Seat[rowCount][colCount];

        // 각 Seat 인스턴스 생성
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                seats[i][j] = new Seat();
            }
        }
        this.rowCount = rowCount;
        this.colCount = colCount;
    }

    public void printSeatMatrix() {
        System.out.print("  ");
        for (int i = 1; i <= 9; i++) {
            System.out.print("  " + i);
        }
        System.out.println();

        for (int i = 0; i < rowCount; i++) {
            System.out.print((char) ('A' + i) + ": ");
            for (int j = 0; j < colCount; j++) {
                Seat s = seats[i][j];
                if (s.isOccupied()) {
                    System.out.print("[O]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }


    public boolean reserve(String name, char rowChar, int col, int numSeat) {
        int row = getRowIndex(rowChar) + 1;

        // 예약 시도 정보가 영화관 좌석 영역을 벗어났을 경우에 대한 처리
        if (row > rowCount || col > colCount || col + numSeat - 1 > colCount) {
            return false;
        }

        // 예약할 좌석 하나씩 확인
        for (int i = 0; i < numSeat; i++) {
            Seat current = seats[row - 1][col - 1 + i];

            // 이미 예약된 자리면 앞서 예약한 자리 모두 취소
            if (current.isOccupied()) {
                for (int j = 0; j < i; j++) {
                    seats[row - 1][col - 1 + j].cancel();
                }
                return false;
            }

            // 빈 자리면 예약
            current.reserve(name);
        }
        return true;
    }

    public int cancel(String name) {
        // 취소된 좌석 수 기록
        int canceledCount = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                Seat seat = seats[i][j];
                if (seat.isOccupied() && seat.match(name)) {
                    seat.cancel();
                    canceledCount++;
                }
            }
        }

        return canceledCount;
    }

    public int cancel(char rowChar, int col, int numSeat) {
        int row = getRowIndex(rowChar) + 1;

        // 존재하지 않는 좌석이면 0 리턴
        if (row > rowCount || col > colCount) {
            return 0;
        }

        // 범위를 벗어나면 범위 재설정
        if (col + numSeat - 1 > colCount) {
            numSeat = colCount - col + 1;
        }

        int canceledCount = 0;
        for (int i = 0; i < numSeat; i++) {
            if (seats[row - 1][col - 1 + i].isOccupied()) {
                seats[row - 1][col - 1 + i].cancel();
                canceledCount++;
            }
        }

        return canceledCount;
    }

    public int getNumberOfReservedSeat() {
        int reservedCount = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                Seat seat = seats[i][j];
                if (seat.isOccupied()) {
                    reservedCount++;
                }
            }
        }

        return reservedCount;
    }

    private int getRowIndex(char uppercaseChar) {
        return uppercaseChar - 'A';
    }
}