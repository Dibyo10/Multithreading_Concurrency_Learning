# Multithreading & Concurrency Learning in Java

<p align="center">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" alt="Java Logo" width="100"/>
</p>

<p align="center">
  <b>All my learnings, notes, and implementations around Multithreading & Concurrency in Java 🚀</b>
</p>

---

## 📚 About This Repository

This repository is a comprehensive collection of my explorations and hands-on implementations of **multithreading** and **concurrency** concepts in Java. It includes code samples, theoretical notes, best practices, common pitfalls, and advanced topics.

Whether you are a beginner or brushing up on concurrency, you'll find practical examples and explanations here!

---

## Table of Contents

1. [Core Multithreading Concepts](#core-multithreading-concepts)
2. [Executor Service](#executor-service)
3. [Practice Questions](#practice-questions)
4. [Concurrent Collections](#concurrent-collections)
5. [Thread Synchronization Demos](#thread-synchronization-demos)
6. [Build & Run Instructions](#build--run-instructions)
7. [Contributing & License](#contributing--license)

---

## Core Multithreading Concepts

Explore the fundamental building blocks of multithreading in Java, including thread creation, coordination, computation, and thread properties.

- **Creating Threads**
  - [`ExtendsThreadClass.java`](./ExtendsThreadClass.java): Creating threads by extending the `Thread` class.
  - [`RunnableThreadExample.java`](./RunnableThreadExample.java): Implementing threads using the `Runnable` interface.
- **Thread Coordination**
  - [`JoinThreadExample.java`](./JoinThreadExample.java): Using `join()` for thread coordination.
  - [`WaitAndNotify.java`](./WaitAndNotify.java): Inter-thread communication using `wait()` and `notify()`.
  - [`ProducerConsumer.java`](./ProducerConsumer.java): Classic producer-consumer problem demo.
- **Thread Priorities & Daemon Threads**
  - [`ThreadPriority.java`](./ThreadPriority.java): Working with thread priorities.
  - [`DaemonUser.java`](./DaemonUser.java): Demonstrating daemon threads.
- **Computation with Threads**
  - [`AdderSubtractor.java`](./AdderSubtractor.java): Performing arithmetic with threads.
  - [`PrimeNumberUsingThreads.java`](./PrimeNumberUsingThreads.java): Calculating primes using threads.

---

## Executor Service

Learn how to manage thread pools and advanced asynchronous tasks using Java's ExecutorService framework.

- [`FixedThreadPoolDemo.java`](./ExecutorService/FixedThreadPoolDemo.java): Using a fixed thread pool.
- [`CachedThreadPoolDemo.java`](./ExecutorService/CachedThreadPoolDemo.java): Using a cached thread pool.
- [`SingleThreadExecutor.java`](./ExecutorService/SingleThreadExecutor.java): Single-threaded executor.
- [`ScheduledExecutorDemo.java`](./ExecutorService/ScheduledExecutorDemo.java): Scheduling tasks.
- [`CallableDemo.java`](./ExecutorService/CallableDemo.java): Using Callable and Future for async computation.
- [`CPU_IntensiveTask.java`](./ExecutorService/CPU_IntensiveTask.java): Handling CPU-intensive tasks.
- [`CountSum100.java`](./ExecutorService/CountSum100.java): Summation tasks with thread pools.

[Browse all ExecutorService examples »](https://github.com/Dibyo10/Multithreading_Concurrency_Learning/tree/main/ExecutorService)

---

## Practice Questions

Sharpen your skills with hands-on problems and coding exercises related to thread communication and synchronization.

- [`OddEven.java`](./PracticeQuestions/OddEven.java): Odd/even number threading problem.
- [`Print1to10.java`](./PracticeQuestions/Print1to10.java): Printing numbers with threads.
- [`ProducerConsumer.java`](./PracticeQuestions/ProducerConsumer.java): Producer-consumer exercise.
- [`SumTo100.java`](./PracticeQuestions/SumTo100.java): Summing numbers using threads.
- [`ThreadABC.java`](./PracticeQuestions/ThreadABC.java): Ordered execution of threads A, B, C.

[See more practice problems »](https://github.com/Dibyo10/Multithreading_Concurrency_Learning/tree/main/PracticeQuestions)

---

## Concurrent Collections

Discover how to use thread-safe collections and synchronization mechanisms for managing shared resources.

- [`BlockingQueueDemo.java`](./concurrentCollection/BlockingQueueDemo.java): Using `BlockingQueue` for producer-consumer scenarios.
- [`CountDown.java`](./concurrentCollection/CountDown.java): Synchronization with CountDownLatch/related constructs.
- [`SynchronizedCollection.java`](./concurrentCollection/SynchronizedCollection.java): Using synchronized collections in Java.

[All concurrent collection demos »](https://github.com/Dibyo10/Multithreading_Concurrency_Learning/tree/main/concurrentCollection)

---

## Thread Synchronization Demos

Explore different synchronization techniques and locking mechanisms.

- [`LockWithCustomVar.java`](./threadSynchronizationDemo/LockWithCustomVar.java): Custom lock implementation.
- [`PrintNums1to100.java`](./threadSynchronizationDemo/PrintNums1to100.java): Synchronized number printing.
- [`SynchronizationDemo.java`](./threadSynchronizationDemo/SynchronizationDemo.java): Demonstration of basic synchronization.

[Browse thread synchronization demos »](https://github.com/Dibyo10/Multithreading_Concurrency_Learning/tree/main/threadSynchronizationDemo)

---

## 🚦 Getting Started

To browse or run the code examples:
1. **Clone this repository:**
   ```bash
   git clone https://github.com/Dibyo10/Multithreading_Concurrency_Learning.git
   ```
2. **Open in your favorite Java IDE** (IntelliJ IDEA, Eclipse, VSCode, etc.).
3. **Run the example files** as standard Java applications.

---

## 🏷️ Key Concepts Covered

- **Thread Basics:** Creating, starting, and managing threads
- **Thread Lifecycle:** Understanding thread states
- **Synchronization:** Locks, synchronized blocks/methods, race conditions
- **Volatile Keyword**
- **Inter-thread Communication:** wait(), notify(), notifyAll()
- **Thread Pools:** ExecutorService, Callable, Future
- **Advanced Locks:** ReentrantLock, ReadWriteLock, Semaphore
- **Atomic Operations:** AtomicInteger, AtomicReference, etc.
- - **Blocking Queue**
- **Concurrent Collections:** CopyOnWriteArrayList, ConcurrentHashMap
- **Deadlocks & Starvation:** Causes and prevention
- **Best Practices:** Designing thread-safe classes and patterns
- **Parallel Streams & Fork/Join Framework**
- **CompletableFuture & Asynchronous Programming**
- **Common Pitfalls and Debugging**

---



## ▶️ How to Run

- Each directory contains self-contained Java files with a `main` method.
- Compile and run with:
  ```bash
  javac path/to/File.java
  java path.to.File
  ```
- Or run directly from your IDE.

---

## 🌟 Useful Resources

- [Official Java Concurrency Documentation](https://docs.oracle.com/javase/tutorial/essential/concurrency/)
- [Java Concurrency in Practice](https://jcip.net/)
- [Baeldung - Guide to Java Concurrency](https://www.baeldung.com/java-concurrency)

---

## 🤝 Contributing

Contributions, suggestions, and doubts are welcome!  
Feel free to open issues or pull requests.

---



<p align="center">
  <img src="https://img.shields.io/badge/Java-Threading-blueviolet?style=for-the-badge&logo=java"/>
  <img src="https://img.shields.io/github/stars/Dibyo10/Multithreading_Concurrency_Learning?style=for-the-badge"/>
</p>
