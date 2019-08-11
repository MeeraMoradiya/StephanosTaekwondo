# Stephano's Taekwondo Institute

Build Restful CRUD API for an institue using Spring MVC, Oracle and Hibernate.

## Description

<p>Master Stephanos, a Taekwondo instructor needs a database to keep track his hundreds
of students. The system requirements are the following:
<ul>
<li>There is only one instructor who teaches all classes and he is the only user</li>

<li>Student data are stored in the database. This includes: their name, date of birth, the
date they joined the school, their mobile number, email, and address. </li>

<li> The school wants to track also the students’ parents (Mother and Father). Most
students live with their parents but NOT all students have parents (some students
might be adults so there is no need to keep track of their parents). We need to store
also parents’ mobile phone and email address. Parents may also be students. </li>

<li>Students should not be deleted from the system but they should be either Active
or Inactive (for those who drop out). </li>
 
<li>The instructor wants to keep track of his inventory, such as, belts, uniforms,
weapons, etc. These should include the product name, product description, cost
price and selling price. </li>

 <li>Students pay fees for membership, tests, purchasing products, etc. The system
must be able to keep track of all money received from students. The system should
be able to show this information for any given date, e.g. by month or within a range
such as, January 1-June 30th 2019. </li>

 <li>A class is offered at specific times and days of the week. For example, one class
might be on Mondays and Thursdays from 5:00-6:00 pm is an intermediate-level
class. Another class might be on Mondays, Wednesdays and Fridays from 6:00-
7:00 pm is a beginner-level class, etc. These provided here are only as an example.</li>

<li>Students may attend any class at any level during each week so there is no
expectation that any particular student will attend any particular class session.
Therefore, the actual attendance of students at each individual class meeting must
be tracked.</li>

 <li>Each student holds a rank in the martial arts. The belt color and the date the student
awarded each rank needs to be kept in the database. A given rank may be held by
many students. While it is customary to think of a student as having a single rank,
it is necessary to track each student’s progress through the ranks. Therefore, every
rank that a student attains is kept in the system. New students joining the school
are automatically given a white belt rank (default). </li>


 <li> Sample ranks (the user can enter any ranks in the Ranks table) are:</li>
1. White
2. Yellow
3. Green
4. Blue
5. Red
6. Black
</ul>


