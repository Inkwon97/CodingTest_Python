-- UserRole
-- SQL Query
-- description은 Null값이 아니어야 한다
-- John Smith에 의해 만들어진 테이블
-- 3rd January 2020
-- before 7th January 2020
-- have never been updated
-- Updated Column이 세팅되어있지 않은 경우

-- role name, description과 status를 포함해야 한다
-- 행들은 role name으로 정렬. 내림차순
-- role name은 Name으로 설정, Description, Status로 설정
-- Status는 DISABLED. IF IsEnabled Column이 0으로 설정되어있다면. else ENABLED

SELECT 
    name Name,
    description Description,
    IF(IsEnabled = 0, 'DISABLED', 'ENABLED') Status,
    Created,
    CreatedBy,
    Updated,
    UpdatedBy
FROM UserRole
where 
    Description is not null
    and
    Name = 'John Smith'
    and
    year(Created) = 2020
    and
    month(Created) = 1
    and
    3 < day(Created) < 7
    and
    Updated is null
order by Name desc

