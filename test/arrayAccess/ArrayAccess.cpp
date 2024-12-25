#include <iostream>
#include <vector>
#include <algorithm>
#include <chrono>
#include <cstdlib>
#include <ctime>

const int LIST_LENGTH = 1000;
const int LIST_MAX_VALUE = 1000000;

void selectionSort1(std::vector<int>& list) {
    for (size_t i = 0; i < list.size(); ++i) {
        int minValue = list[i];
        size_t minIdx = i;
        for (size_t j = i + 1; j < list.size(); ++j) {
            if (list[j] < minValue) {
                minValue = list[j];
                minIdx = j;
            }
        }
        list[minIdx] = list[i];
        list[i] = minValue;
    }
}

void selectionSort2(std::vector<int>& list) {
    for (size_t i = 0; i < list.size(); ++i) {
        size_t minIdx = i;
        for (size_t j = i + 1; j < list.size(); ++j) {
            if (list[j] < list[minIdx]) {
                minIdx = j;
            }
        }
        std::swap(list[i], list[minIdx]);
    }
}

void measureSortPerformance() {
    double averageRatio = 0.0;

    for (int iteration = 0; iteration < 4; ++iteration) {
        // Generate random lists
        std::vector<int> list1(LIST_LENGTH);
        for (int& num : list1) {
            num = rand() % LIST_MAX_VALUE;
        }
        std::vector<int> list2 = list1; // Clone the list

        // Time selectionSort1
        auto startTime1 = std::chrono::high_resolution_clock::now();
        selectionSort1(list1);
        auto endTime1 = std::chrono::high_resolution_clock::now();
        auto time1 = std::chrono::duration_cast<std::chrono::nanoseconds>(endTime1 - startTime1).count();

        // Time selectionSort2
        auto startTime2 = std::chrono::high_resolution_clock::now();
        selectionSort2(list2);
        auto endTime2 = std::chrono::high_resolution_clock::now();
        auto time2 = std::chrono::duration_cast<std::chrono::nanoseconds>(endTime2 - startTime2).count();

        // Update average ratio
        averageRatio += static_cast<double>(time2) / time1;

        // Print results for this iteration
        std::cout << "selectionSort1: " << time1 << " ns\n";
        std::cout << "selectionSort2: " << time2 << " ns\n";
        std::cout << "Difference (2 - 1): " << (time2 - time1) << " ns\n";
        std::cout << "Ratio (2 / 1): " << static_cast<double>(time2) / time1 << "\n\n";
    }

    // Calculate and print the average ratio
    averageRatio /= 4;
    std::cout << "Average ratio (2 / 1): " << averageRatio << "\n";
}

int main() {
    srand(static_cast<unsigned>(time(0))); // Seed random number generator
    measureSortPerformance();
    return 0;
}
