--����17. emp���̺� ���� �����ȣ�� 7900�� ����� ���� ��¥�� �Ի��� ����� �̸��� �Ի����� ����Ͻÿ�.
select ename, hiredate
from emp
where hiredate = (select hiredate
                   from emp
                   where empno = 7900);

--����18. emp���̺� ���� ���ӻ��(mgr)�� KING�� ��� ����� �̸��� �޿��� ����Ͻÿ�.
select ename, sal
from emp
where mgr = (select empno
              from emp
              where ename = 'KING');

--����19. EMPLOYEES ���̺��� (�޿��� ���)���� ���� ����� ������ �����ȣ,�̸�,������,�޿�,�μ���ȣ�� ����Ͽ���
select employee_id, last_name || ' ' || first_name, job_id, salary, department_id
from employees
where salary < (select avg(salary)
                from employees);

--����20. EMPLOYEES ���̺��� (Kochhar�� �޿�)���� ���� ����� ������ �����ȣ,�̸�,������,�޿��� ����϶�.
select employee_id, last_name || ' ' || first_name, job_id, salary
from employees
where salary > (select salary
                from employees
                where last_name = 'Kochhar');

--����21. emp���̺� ���� (BLAKE�� ���� �μ�)�� �ִ� ������� �̸��� �Ի����� ���ϴµ� BLAKE�� �����ϰ� ����Ͻÿ�.(BLAKE�� �������� �� ����)
select ename, hiredate
from emp
where deptno in (select deptno
                 from emp
                 where ename = 'BLAKE')
and ename != 'BLAKE';




