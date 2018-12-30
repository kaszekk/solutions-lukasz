package pl.coderstrust.hoare;

class HoarePartition {
    static int[] partitionTable(int[] tableForPartition, int pivotIndex) {
        if (tableForPartition == null) {
            throw new IllegalArgumentException("Table cannot be null.");
        }
        if (tableForPartition.length == 0) {
            throw new IllegalArgumentException("Table cannot be empty.");
        }
        if (pivotIndex < 0) {
            throw new IllegalArgumentException("Pivot index must be greater or equal 0.");
        }
        if (pivotIndex >= tableForPartition.length) {
            throw new IllegalArgumentException("Pivot index must be lower than table size.");
        }
        int[] partitionedTable = tableForPartition.clone();
        int leftCursor = 1;
        int rightCursor = partitionedTable.length - 1;
        int pivotValue = partitionedTable[pivotIndex];
        swapElementsInArray(partitionedTable, 0, pivotIndex);
        while (leftCursor < rightCursor) {
            while (partitionedTable[leftCursor] <= pivotValue && leftCursor != partitionedTable.length - 1) {
                leftCursor++;
            }
            while (partitionedTable[rightCursor] > pivotValue && rightCursor != 0) {
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
