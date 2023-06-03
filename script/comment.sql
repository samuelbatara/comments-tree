create table if not exists comment (
  id bigint not null,
  post_id bigint not null,
  reply_to bigint,
  body varchar not null,
  posted_date date not null,
  primary key(id),
  foreign key (post_id) references post(id)
);

create sequence if not exists seq_comment_id
  as bigint
  increment by 1
  start with 1
  owned by comment.id;

alter table comment
 alter column id set default nextval('seq_comment_id');

create index if not exists idx_comment_post_id on comment using btree (
  post_id ASC
);

insert into comment (post_id, reply_to, body, posted_date)
values
  (1, null, 'Saya dukung Indonesia!', '2023-06-03'), -- id=1
  (1, null, 'Saya dukung Argentina!', '2023-06-03'), -- id=2
  (1, 2, 'Wah, tidak nasionalis', '2023-06-03'), -- id=3
  (1, 2, 'Dukung Indonesia woi', '2023-06-03'), -- id=4
  (1, 4, 'Bener ayo dukung Indonesia', '2023-06-03'); -- id==5
