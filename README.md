# Event Booking

[[_TOC_]]

---

:scroll: **START**

## Introduction
In today's fast-paced world, the convenience of booking systems has become an essential aspect of daily life. From booking tickets for a concert or reserving a spot at a conference, these systems are used widely by individuals and businesses alike.

---

## Task Description
The system will allow users to create, find and reserve tickets for events, view and manage their reservations and to be notified before the event kickoff.

A **user** has:
- name (limited to 100 characters);
- email (valid email format);
- password (minimum 8 characters).

An **event** has:
- name (limited to 100 characters);
- date (in a valid date format);
- available attendees count (positive integer limited to 1000);
- event description (limited to 500 characters).
- category (Concert, Conference, Game)

Develop a set of REST service APIs that allows users to:
- Create an account;
- Create events;
- Search and reserve tickets for events;
- Send notification to users before event starts.

> Feel free to make assumptions for the design approach. 

## Requirements
While implementing your solution **please take care of the following requirements:**

### Functional requirements
- Add 2 new methods, one to **view** your booked events and one to **cancel** your reservation;

### Non-functional requirements
- The project MUST be buildable and runnable;
- The project MUST have Unit tests;
- Input/output data MUST be in JSON format;
---
### Submission
- You are to create a github repository, add the username: djfemz as collaborator
- Deadline for submission is the 13th of April 2024.
:scroll: **END**
