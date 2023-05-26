--문제1. emp 테이블에서 사원번호, 사원이름, 월급을 출력하시오.
select empno, ename, sal
from emp;

--문제2. emp 테이블에서 사원번호, 사원이름, 월급, 연봉을 구하고 각각 컬럼명은 사원번호, 사원이름, 월급, 연봉으로 출력하시오.
select empno as "사원번호", ename as "사원이름", sal as "월급", sal * 12 as "연봉"
from emp;

--문제3. employees 테이블에서 모든 종업원의 급여를 $300증가 시키기 위해서 덧셈 연산자를 사용하고 결과에 이름과 SALARY, SALARY+300를 출력 합니다.
select last_name || ' ' || first_name, salary, salary + 300
from employees;

--문제4. EMPLOYEES 테이블에서 이름(last_name + first_name)과 연봉을 "KING: 1 Year salary = 60000" 형식으로 출력하여라. 
select last_name || ' ' || first_name || ': 1Year salary = ' || salary * 12
from employees;

--문제5. EMPLOYEES 테이블에서 입사일자가 1995년 1월 1일 이후에 입사한 사원의 정보를 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하라
select employee_id, last_name || ' ' || first_name, job_id, salary, hire_date, department_id
from employees
where hire_date > '1995/01/01';

--문제6. EMPLOYEES 테이블에서 급여가 3000에서 5000사이의 정보를 성명, 담당업무, 급여, 부서번호를 출력하라.
select last_name || ' ' || first_name, job_id, salary, department_id
from employees
where salary between 3000 and 5000;

--문제7. EMPLOYEES 테이블에서 사원번호가 144, 176, 200 인 사원의 정보를 사원번호, 성명, 담당업무, 급여, 입사일자를 출력하라.
select employee_id, last_name || ' ' || first_name, job_id, salary, hire_date
from employees
where employee_id in(144, 176, 200);

--문제8.emp 테이블 에서 업무가 SALESMAN 또는 MANAGER이면서 급여가 1600, 2975, 2850이 아닌 모든 사원의 이름, 업무 및 급여를 표시하시오.
select ename, job, sal
from emp
where job in('SALESMAN', 'MANAGER')
and sal not in(1600, 2975, 2850);

--문제9.EMPLOYEES 테이블에서 부서별로 인원수, 평균 급여, 최저급여, 최고급여, 급여의 합을 구하여 출력하라.
select department_id, count(department_id), round(avg(salary), 3), min(salary), max(salary), sum(salary)
from employees
group by department_id
order by department_id desc;

--문제 10. EMPLOYEES 테이블에서 부서 인원이 4명보다 많은 부서의 부서번호, 인원수, 급여의 합을 구하여 출력하여라(GROUP BY, HAVING)
select department_id, count(department_id), sum(salary)
from employees
group by department_id
having count(department_id) > 4;

--문제 11. EMPLOYEES 테이블에서 전체 월급이 10000을 초과하는 각 업무에 대해서 업무와 월급여 합계를 출력하라. 단 job_id가 'SA '로 시작하는 직원은 제외하고 월 급여 합계로 정렬(내림차순) 하라. 
select job_id, sum(salary)
from employees
where job_id not like 'SA%'
group by job_id
having sum(salary) > 10000
order by sum(salary) desc;

--문제12. emp테이블에서 사원이름 중 A가 포함된 사원이름을 구하고 그 이름 중 앞에서 3자만 추출하여 출력
select substr(ename, 1, 3)
from emp
where ename like '%A%';

--여기서 부터 join문제

--문제13. 모든 사원의 이름, 부서번호, 부서이름을 표시하시오. (emp, dept)
select t1.ename, t1.deptno, t2.dname
from emp t1, dept t2
where t1.deptno = t2.deptno;

select t1.ename, t1.deptno, t2.dname
from emp t1
join dept t2
on t1.deptno = t2.deptno;

--문제14. 업무가 MANAGER인 사원의 정보를 이름, 업무, 부서명, 근무지 순으로 출력하시오. ( emp, dept)
select t1.ename, t1.job, t2.dname, t2.loc
from emp t1, dept t2
where t1.deptno = t2.deptno and t1.job in('MANAGER');

select t1.ename, t1.job, t2.dname, t2.loc
from emp t1
join dept t2
on t1.deptno = t2.deptno and t1.job in('MANAGER');

--문제15. 커미션(emp테이블의 comm 컬럼이용)을 받고 급여가 1,600이상인 사원의 사원이름, 부서명, 근무지를 출력하시오.( emp, dept)
select t1.ename, t2.dname, t2.loc
from emp t1, dept t2
where t1.deptno = t2.deptno
and t1.comm is not null and t1.comm != 0
and t1.sal >= 1600;

select t1.ename, t2.dname, t2.loc
from emp t1
join dept t2
on t1.deptno = t2.deptno and t1.comm is not null and t1.sal >= 1600;

--문제16. 근무지가 CHICAGO인 모든 사원의 이름,업무,부서번호 및 부서이름을 표시하시오. ( emp, dept)
select t1.ename, t1.job, t1.deptno, t2.dname
from emp t1, dept t2
where t1.deptno = t2.deptno
and t2.loc = 'CHICAGO';

select t1.ename, t1.job, t1.deptno, t2.dname
from emp t1
join dept t2
on t1.deptno = t2.deptno and t2.loc = 'CHICAGO';




