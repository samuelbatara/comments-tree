create table if not exists post (
  id bigint not null,
  body varchar not null,
  posted_date date not null,
  primary key(id)
);

create sequence if not exists seq_post_id
  as bigint
  increment by 1
  start with 1
  owned by post.id;

alter table post
  alter column id set default nextval('seq_post_id');

insert into post (body, posted_date)
values
  ('Indonesia vs Argentina in FIFA Match Day!', '2023-06-03')