--문제17. emp테이블 에서 사원번호가 7900인 사원과 같은 날짜에 입사한 사람의 이름과 입사일을 출력하시오.
select ename, hiredate
from emp
where hiredate = (select hiredate
                   from emp
                   where empno = 7900);

--문제18. emp테이블 에서 직속상사(mgr)가 KING인 모든 사원의 이름과 급여를 출력하시오.
select ename, sal
from emp
where mgr = (select empno
              from emp
              where ename = 'KING');

--문제19. EMPLOYEES 테이블에서 (급여의 평균)보다 적은 사원의 정보를 사원번호,이름,담당업무,급여,부서번호를 출력하여라
select employee_id, last_name || ' ' || first_name, job_id, salary, department_id
from employees
where salary < (select avg(salary)
                from employees);

--문제20. EMPLOYEES 테이블에서 (Kochhar의 급여)보다 많은 사원의 정보를 사원번호,이름,담당업무,급여를 출력하라.
select employee_id, last_name || ' ' || first_name, job_id, salary
from employees
where salary > (select salary
                from employees
                where last_name = 'Kochhar');

--문제21. emp테이블 에서 (BLAKE와 같은 부서)에 있는 사원들의 이름과 입사일을 구하는데 BLAKE는 제외하고 출력하시오.(BLAKE가 여러명일 수 있음)
select ename, hiredate
from emp
where deptno in (select deptno
                 from emp
                 where ename = 'BLAKE')
and ename != 'BLAKE';




