--����1. emp ���̺��� �����ȣ, ����̸�, ������ ����Ͻÿ�.
select empno, ename, sal
from emp;

--����2. emp ���̺��� �����ȣ, ����̸�, ����, ������ ���ϰ� ���� �÷����� �����ȣ, ����̸�, ����, �������� ����Ͻÿ�.
select empno as "�����ȣ", ename as "����̸�", sal as "����", sal * 12 as "����"
from emp;

--����3. employees ���̺��� ��� �������� �޿��� $300���� ��Ű�� ���ؼ� ���� �����ڸ� ����ϰ� ����� �̸��� SALARY, SALARY+300�� ��� �մϴ�.
select last_name || ' ' || first_name, salary, salary + 300
from employees;

--����4. EMPLOYEES ���̺��� �̸�(last_name + first_name)�� ������ "KING: 1 Year salary = 60000" �������� ����Ͽ���. 
select last_name || ' ' || first_name || ': 1Year salary = ' || salary * 12
from employees;

--����5. EMPLOYEES ���̺��� �Ի����ڰ� 1995�� 1�� 1�� ���Ŀ� �Ի��� ����� ������ �����ȣ, ����, ������, �޿�, �Ի�����, �μ���ȣ�� ����϶�
select employee_id, last_name || ' ' || first_name, job_id, salary, hire_date, department_id
from employees
where hire_date > '1995/01/01';

--����6. EMPLOYEES ���̺��� �޿��� 3000���� 5000������ ������ ����, ������, �޿�, �μ���ȣ�� ����϶�.
select last_name || ' ' || first_name, job_id, salary, department_id
from employees
where salary between 3000 and 5000;

--����7. EMPLOYEES ���̺��� �����ȣ�� 144, 176, 200 �� ����� ������ �����ȣ, ����, ������, �޿�, �Ի����ڸ� ����϶�.
select employee_id, last_name || ' ' || first_name, job_id, salary, hire_date
from employees
where employee_id in(144, 176, 200);

--����8.emp ���̺� ���� ������ SALESMAN �Ǵ� MANAGER�̸鼭 �޿��� 1600, 2975, 2850�� �ƴ� ��� ����� �̸�, ���� �� �޿��� ǥ���Ͻÿ�.
select ename, job, sal
from emp
where job in('SALESMAN', 'MANAGER')
and sal not in(1600, 2975, 2850);

--����9.EMPLOYEES ���̺��� �μ����� �ο���, ��� �޿�, �����޿�, �ְ�޿�, �޿��� ���� ���Ͽ� ����϶�.
select department_id, count(department_id), round(avg(salary), 3), min(salary), max(salary), sum(salary)
from employees
group by department_id
order by department_id desc;

--���� 10. EMPLOYEES ���̺��� �μ� �ο��� 4���� ���� �μ��� �μ���ȣ, �ο���, �޿��� ���� ���Ͽ� ����Ͽ���(GROUP BY, HAVING)
select department_id, count(department_id), sum(salary)
from employees
group by department_id
having count(department_id) > 4;

--���� 11. EMPLOYEES ���̺��� ��ü ������ 10000�� �ʰ��ϴ� �� ������ ���ؼ� ������ ���޿� �հ踦 ����϶�. �� job_id�� 'SA '�� �����ϴ� ������ �����ϰ� �� �޿� �հ�� ����(��������) �϶�. 
select job_id, sum(salary)
from employees
where job_id not like 'SA%'
group by job_id
having sum(salary) > 10000
order by sum(salary) desc;

--����12. emp���̺��� ����̸� �� A�� ���Ե� ����̸��� ���ϰ� �� �̸� �� �տ��� 3�ڸ� �����Ͽ� ���
select substr(ename, 1, 3)
from emp
where ename like '%A%';

--���⼭ ���� join����

--����13. ��� ����� �̸�, �μ���ȣ, �μ��̸��� ǥ���Ͻÿ�. (emp, dept)
select t1.ename, t1.deptno, t2.dname
from emp t1, dept t2
where t1.deptno = t2.deptno;

select t1.ename, t1.deptno, t2.dname
from emp t1
join dept t2
on t1.deptno = t2.deptno;

--����14. ������ MANAGER�� ����� ������ �̸�, ����, �μ���, �ٹ��� ������ ����Ͻÿ�. ( emp, dept)
select t1.ename, t1.job, t2.dname, t2.loc
from emp t1, dept t2
where t1.deptno = t2.deptno and t1.job in('MANAGER');

select t1.ename, t1.job, t2.dname, t2.loc
from emp t1
join dept t2
on t1.deptno = t2.deptno and t1.job in('MANAGER');

--����15. Ŀ�̼�(emp���̺��� comm �÷��̿�)�� �ް� �޿��� 1,600�̻��� ����� ����̸�, �μ���, �ٹ����� ����Ͻÿ�.( emp, dept)
select t1.ename, t2.dname, t2.loc
from emp t1, dept t2
where t1.deptno = t2.deptno
and t1.comm is not null and t1.comm != 0
and t1.sal >= 1600;

select t1.ename, t2.dname, t2.loc
from emp t1
join dept t2
on t1.deptno = t2.deptno and t1.comm is not null and t1.sal >= 1600;

--����16. �ٹ����� CHICAGO�� ��� ����� �̸�,����,�μ���ȣ �� �μ��̸��� ǥ���Ͻÿ�. ( emp, dept)
select t1.ename, t1.job, t1.deptno, t2.dname
from emp t1, dept t2
where t1.deptno = t2.deptno
and t2.loc = 'CHICAGO';

select t1.ename, t1.job, t1.deptno, t2.dname
from emp t1
join dept t2
on t1.deptno = t2.deptno and t2.loc = 'CHICAGO';




