package pl.coderstrust.hoarepartition;

class HoarePartition {
    static int[] applyHoare(int[] tableForPartition, int pivotIndex) {
        if (tableForPartition == null) {
            throw new IllegalArgumentException("array for partition cannot be null");
        }
        if (tableForPartition.length == 0) {
            throw new IllegalArgumentException("array for partition length must be greater than zero");
        }
        if (pivotIndex < 0) {
            throw new IllegalArgumentException("pivotIndex cannot be negative");
        }
        if (pivotIndex >= tableForPartition.length) {
            throw new IllegalArgumentException("pivotIndex out of bound");
        }
        int[] partitionedTable = tableForPartition.clone();
        int leftCursor = 1;
        int rightCursor = partitionedTable.length - 1;
        swapElementsInArray(partitionedTable, 0, pivotIndex);
        while (leftCursor < rightCursor) {
            while (partitionedTable[leftCursor] <= partitionedTable[0] && leftCursor != partitionedTable.length - 1) {
                leftCursor++;
            }
            while (partitionedTable[rightCursor] > partitionedTable[0] && rightCursor != 0) {
                rightCursor--;
            }
            if (leftCursor < rightCursor) {
                swapElementsInArray(partitionedTable, leftCursor, rightCursor);
            }
        }
        swapElementsInArray(partitionedTable, 0, rightCursor);
        return partitionedTable;
    }

    private static void swapElementsInArray(int[] array, int indexOfFirstElement, int indexOfSecondElement) {
        int temp = array[indexOfFirstElement];
        array[indexOfFirstElement] = array[indexOfSecondElement];
        array[indexOfSecondElement] = temp;
    }
}
