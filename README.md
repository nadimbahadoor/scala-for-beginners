# scala-for-beginners
Source code for the "Scala For Beginners" book. https://leanpub.com/scalaforbeginners/


# Get The Book
You can buy the book at https://leanpub.com/scalaforbeginners/


# Who Should Read This Book
This book is designed from the ground up with the **complete beginner** in mind, as well as focusing on day-to-day **real-world** Scala programming especially within an enterprise context. Therefore, you will find that this book contains more than enough of the **basics**, in addition to the **practical** stuff - and of course the content is introduced in a **step-by-step** way.  

This book is also a great guide for **experienced programmers** from different backgrounds, such as, *Java*, .*NET*, *C++*, and others. It is outright true whilst working in large enterprise projects - whose ecosystem typically comprises of numerous programming languages - and as a result you may need to get **up to speed fast** so as to work on a Scala project, or alongside a Scala team.  

Likewise, **data scientists** and **big data engineers** who already code in, say, *Python*, *R*, or *Java*, will have a **better understanding** of Scala in general and its development environment. This increased awareness will no doubt help to interface with a number of tools from the Scala ecosystem, such as, [Apache Spark](https://spark.apache.org/) - a popular big data technology for data analytics, and machine learning.  

Naturally, this book is equally intended for the typical **programmer**, or **student**, or **anyone** who wants to **quickly** learn a modern programming language.  


# Book Structure and Content Organization
The chapters in this book are organized in such a way to **gradually** and **incrementally** learn Scala. In fact, each section is logically ordered with a **fast-track**, or **crash course**, perspective, such that you can get familiar with Scala in just about **7 days**. Nevertheless, it goes without saying that the **7 days** time frame is somewhat arbitrary, and will very much depend on your experience level and time commitment. Needless to say that you can skip certain chapters if you are already aware with its content, or decide to follow along, or cherry-pick specific sections, or even carry on at your own pace.  

It is worth mentioning, though, that each chapter provides a **natural ordering** to help you easily build-up your knowledge of the various Scala features. For instance, you will be shown how to use **Pattern Matching** before being able to apply it within, say, a `map`, or a `flatMap` function. Of course, I would not recommend cramming the content in just *one day* - having said that, you can do the whole thing in a short amount of time. The best thinking however is to take the first leap and get started!   

In the first chapter - *Day One: Setup your Scala development environment* - you will be provided with a **general overview** of the Scala programming language, along with **step-by-step** instructions for setting up your Scala coding environment. You will then be introduced to some of the **essential components** as prerequisite for the upcoming chapters.  
In the second chapter - *Day Two: Learn Functions, Classes and Objects* - you will create and use **functions**, **classes** and **objects**. Generally speaking, the features that we illustrate in this chapter will somewhat form a large part in your typical **day-to-day** Scala coding.  

In the third chapter - *Day Three: Learn Traits, and create your first Scala application* - you will be introduced to **traits**, and how to use [sbt](https://en.wikipedia.org/wiki/Sbt_(software)) (the build tool for Scala), and begin to create a real-world Scala application.  

In the fourth chapter - *Day Four: Scala's Immutable and Mutable collections* - we start off by reviewing some of the basic **data structures** in computer science, and then proceed with numerous examples in using Scala's **Immutable** and **Mutable** collections.  

In the fifth chapter - *Day Five: Scala's ready to use collection functions* - we go over the wide range of **functions**, which Scala provides **out-of-the-box** to faciliate the everyday interactions with collection data structures.  

In the sixth chapter - *Day Six: Asynchronous programming, and testing your Scala application* - you will make use of Scala **Futures** for writing non-blocking code. It will also be time to introduce [ScalaTest](http://www.scalatest.org/) - a prominent tool for testing Scala applications.  

In the final seventh chapter - *Day Seven: Your step-by-step Scala application* - we put together a Scala application from the concepts that we've learned in this book. In particular, the Scala application will be a **multi-project**, which is quintessential to most enterprise platforms by having various parts of the system encapsulated in small, and reusable, projects.  


# Prerequisites, Source Code and Notation
You do not need to learn another programming language before picking up Scala. This book will introduce all the fundamentals first, illustrate the nice **interop** between Java and Scala, before gradually delving into more advanced concepts.  

The source code for all the examples in this book is available at the [Scala For Beginners](https://github.com/nadimbahadoor/scala-for-beginners) GitHub project under the Apache 2 License. See **appendix** for further instructions on **importing** the source code into the **IntelliJ IDEA** code editor.  

Similiar to the hands-on code snippets at [http://allaboutscala.com](http://allaboutscala.com), we keep the data points consistent throughout the book. For instance, you might see a collection of type `String` to represent various Donut names, followed by illustrations on how to use the `map` function as shown below. With the concise data points across the chapters, you are able to focus on the concept at hand, rather than having to constantly familiarize yourself with different sample data. Besides, we keep the examples **short**, **easy-going**, and **fun**!  

```scala
println("Step 1: How to initialize a Sequence of donuts")
val donuts1 = Seq("Plain", "Strawberry", "Glazed")
println(s"Elements of donuts1 = $donuts1")
```

You should see the following output when you run your Scala application in IntelliJ:  

> Step 1: How to initialize a Sequence of donuts  
> Elements of donuts1 = List(Plain, Strawberry, Glazed)  

**2. How to append the word Donut to each element using the map function**  
Using the `map` function, we can easily apply a **transformation** on the collection from Step 1 that will append the `" Donut"` literal to every Donut name.  

```scala
println("\nStep 2: How to append the word Donut to each element using the map function")
val donuts2 = donuts1.map(_ + " Donut")
println(s"Elements of donuts2 = $donuts2")
```

You should see the following output when you run your Scala application in IntelliJ:  

> Step 2: How to append the word Donut to each element using the map function  
> Elements of donuts2 = List(Plain Donut, Strawberry Donut, Glazed Donut)  


# What We Do Not Cover  
This book does **not** claim that **Functional** programming is somewhat higher in rank compared to **Object Oriented** programming. Whilst it is **not** a definitive guide on **Functional** concepts, we gently bring your attention to the following concerns that - as programmers in this *day and age* who are expected to deliver software that scale **horizontally** and **vertically** by default - present many challenges in large enterprise code base: (1) *mutable variables*, (2) *mutable global states*, (3) *concurrency across multi-cores and multi-nodes*, (4) *refactoring nightmares following the ever changing requirements*, (5) *divide-and-conquer or equivalent MapReduce operations to speed up heavy computation*, to name just a few.  

With Scala supporting both **Functional** and **Object Oriented** models, you ultimately get two great tools within your programming toolbox. We therefore introduce, along with mixing and matching, several paradigms from both worlds. The code samples nevertheless put emphasis on **functions** - as *pure* as possible - in order to have a clear *separation* with your **mutable** data points. Throughout the book, we spare no detail in suggesting whenever you can further benefit from other mainstream **Functional** libraries and concepts.  

We do **not** cover **macros** and general **metaprogramming** with Scala, and they are certainly yet another pragmatic facet of the language. Thanks to the valued feedback from our readers at [http://allaboutscala.com](http://allaboutscala.com), it would be quite odd for a **beginner** to jump straight into **metaprogramming** techniques. Instead, and where required, we identify libraries that provide *higher level of abstractions* over **macros**.  


# Acknowledgements
I have always supported the Scala [Code of Conduct](https://www.scala-lang.org/conduct/), and am truly an avid believer that every question presents an opportunity to learn! In addition to the fact that no question should be left unanswered, I want to express my sincere appreciation to all the readers of the [http://allaboutscala.com](http://allaboutscala.com) blog for their invaluable **feedback** and **comments** over the past years - these have greatly shaped up the structure of this book.  

# Contact  
I hope you've enjoyed our tutorials at [http://allaboutscala.com](http://allaboutscala.com), and will equally explore and continue your Scala journey with me through this book. So thank you very much for your time.  

If you spot any silly typos, or errata, or just want to say "*Hi!*" - I can be reached at [http://allaboutscala.com/contact/](http://allaboutscala.com/contact/). For general purpose Scala questions though, I always recommend posting a **comment** under the respective topic at [http://allaboutscala.com](http://allaboutscala.com) for the benefit of the wider Scala community.  
