# Producer_Consumer_Java
Working to synchronize threads without blocking

The problem is working with multiple threads to keep data in three different queue classes. There is a problem between threads which read data after the writer thread. They are trying to read at the same time.I m working to synchronize threads without blocking. I used monitors to supply synchronization.

# Solution

I implemented priority classes for three different queues. They are Lex, Euc, Bmx priority queues. We have just one prioritiyQueue class, we decided to type of queue with comparator object which implemented from Comporator class. I defined a colorRGB class to keep red,green and blue values of pixels. We keep colorRGB object in the queues. Then there is a producerConsumer class to manage threads. There are four threads. First thread is producer thread. It reads values from image file and keep it. Other threads race for the catch them. We used the monitors to synchronize them.When counter is smaller than hundred, it inserts the values from image to queues. When it reaches to hundred, first thread sleeps and others start to race. There is no order to know which thread will be catch it first.OS decides that. I used to produce-consumer algorithm from OS lecture book and I tried to implement priority queues from Data Structure lecture book.
