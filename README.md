# Page Replacement Technique

## Introduction

Page Replacement technique is used to replace page in memory frame with in os .
The popular 3 approaches are

1. FIFO
2. LRU
3. Optimal

### FIFO( First In First Out ) Algorithm:

1. Initialize an empty frame of size frames.
2. Set pageFault = 0 and frameCount = 0.
3. For each page in the pages array:
   - If the page is not in the frame:
   - Replace the page at frameCount with the current page.
   - Increment frameCount (modulo the frame size for circular replacement).
   - Increment pageFault.
   - If the page is already in the frame, do nothing.
4. At the end, return pageFault.

### LRU( Least Recently Used ) Algorithm:

1. Initialize an empty frame of size frames.
2. Maintain a list of recently used pages.
3. Set pageFault = 0.
4. For each page in the pages array:
   - If the page is not in the frame:
     - If the frame is full, remove the least recently used page (the one at the front of the list).
     - Add the page to the frame and the end of the list.
     - Increment pageFault.
   - If the page is already in the frame:
     - Update the recently used list by moving the page to the end.
5. At the end, return pageFault.

### Optimal Algorithm:

1. Initialize an empty frame of size frames.
2. Set pageFault = 0.
3. For each page in the pages array (current index i):
   - If the page is not in the frame:
     - If the frame is full, find the page that will not be used for the longest period of time:
     - Look ahead in the pages array to see when each page in the frame will next be used.
     - Replace the page with the largest index or the one not used at all.
   - Add the page to the frame.
   - Increment pageFault.
   - If the page is already in the frame, do nothing.
4. At the end, return pageFault.

> [!IMPORTANT]
> Import Java modules correctly and change the package part in the file
